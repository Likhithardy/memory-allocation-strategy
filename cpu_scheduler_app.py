
import streamlit as st
import random
import matplotlib.pyplot as plt

st.set_page_config(page_title="Memory Allocation Simulator", layout="wide")


def init():
    if "total_memory" not in st.session_state:
        st.session_state.total_memory = 100
    if "holes" not in st.session_state:
        st.session_state.holes = [{"start": 0, "size": st.session_state.total_memory}]
    if "allocations" not in st.session_state:
        st.session_state.allocations = []
    if "next_pid" not in st.session_state:
        st.session_state.next_pid = 1
    if "strategy" not in st.session_state:
        st.session_state.strategy = "First Fit"

def reset_all():
    st.session_state.holes = [{"start": 0, "size": st.session_state.total_memory}]
    st.session_state.allocations = []
    st.session_state.next_pid = 1

init()

def allocate_memory(size):
    holes = sorted(st.session_state.holes, key=lambda h: h["start"])
    fit = None

    if st.session_state.strategy == "First Fit":
        for h in holes:
            if h["size"] >= size:
                fit = h
                break

    elif st.session_state.strategy == "Best Fit":
        valid = [h for h in holes if h["size"] >= size]
        if valid:
            fit = min(valid, key=lambda h: h["size"])

    elif st.session_state.strategy == "Worst Fit":
        valid = [h for h in holes if h["size"] >= size]
        if valid:
            fit = max(valid, key=lambda h: h["size"])

    if not fit:
        st.warning(" Not enough space to allocate this process.")
        return False

    pid = st.session_state.next_pid
    st.session_state.next_pid += 1


    allocation = {"pid": pid, "start": fit["start"], "size": size}
    st.session_state.allocations.append(allocation)

    fit["start"] += size
    fit["size"] -= size
    if fit["size"] == 0:
        st.session_state.holes.remove(fit)

    st.success(f" Process P{pid} allocated {size} units using {st.session_state.strategy}.")
    merge_holes()
    return True


def deallocate_memory(pid):
    allocation = next((a for a in st.session_state.allocations if a["pid"] == pid), None)
    if not allocation:
        st.warning(" Process not found.")
        return
    st.session_state.allocations.remove(allocation)
    st.session_state.holes.append({"start": allocation["start"], "size": allocation["size"]})
    merge_holes()
    st.info(f" Process P{pid} deallocated and memory freed.")


def merge_holes():
    holes = sorted(st.session_state.holes, key=lambda h: h["start"])
    merged = []
    for h in holes:
        if not merged:
            merged.append(h)
        else:
            prev = merged[-1]
            if prev["start"] + prev["size"] == h["start"]:
                prev["size"] += h["size"]
            else:
                merged.append(h)
    st.session_state.holes = merged


def draw_memory_layout():
    fig, ax = plt.subplots(figsize=(10, 2))
    ax.set_xlim(0, st.session_state.total_memory)
    ax.set_ylim(0, 1)
    ax.axis("off")


    colors = {}
    for alloc in st.session_state.allocations:
        pid = alloc["pid"]
        color = colors.get(pid, f"#{random.randint(0, 0xFFFFFF):06x}")
        colors[pid] = color
        ax.barh(0, alloc["size"], left=alloc["start"], height=0.8, color=color, edgecolor="black")
        ax.text(alloc["start"] + alloc["size"]/2, 0, f"P{pid}", ha='center', va='center', color='white')


    for hole in st.session_state.holes:
        ax.barh(0, hole["size"], left=hole["start"], height=0.8, color='lightgrey', edgecolor="black", alpha=0.4)
        ax.text(hole["start"] + hole["size"]/2, 0, "Free", ha='center', va='center', color='black')

    st.pyplot(fig)


with st.sidebar:
    st.header(" Configuration")
    st.session_state.strategy = st.selectbox("Select Allocation Strategy", ["First Fit", "Best Fit", "Worst Fit"])
    st.session_state.total_memory = st.number_input("Total Memory Size", min_value=50, max_value=1000, value=st.session_state.total_memory)
    if st.button("Reset Simulation"):
        reset_all()

    st.markdown("---")
    st.subheader(" Allocate Process")
    alloc_size = st.number_input("Process size (units)", min_value=1, max_value=st.session_state.total_memory, value=20)
    if st.button("Allocate"):
        allocate_memory(alloc_size)

    st.markdown("---")
    st.subheader(" Deallocate Process")
    if st.session_state.allocations:
        pid_choices = [a["pid"] for a in st.session_state.allocations]
        selected_pid = st.selectbox("Select Process ID to deallocate", pid_choices)
        if st.button("Deallocate"):
            deallocate_memory(selected_pid)
    else:
        st.info("No processes to deallocate.")


st.title("Dynamic Memory Allocation Simulator")
st.write(
    """
This visual simulation demonstrates **First Fit**, **Best Fit**, and **Worst Fit**
strategies for **Dynamic Memory Allocation** in Operating Systems.
"""
)


st.subheader("Memory Layout")
draw_memory_layout()


st.subheader("Current Allocations")
if st.session_state.allocations:
    st.table(st.session_state.allocations)
else:
    st.info("No active allocations.")


st.subheader("Free Memory Blocks (Holes)")
if st.session_state.holes:
    st.table(st.session_state.holes)
else:
    st.warning("No free memory available.")


total_alloc = sum(a["size"] for a in st.session_state.allocations)
total_free = sum(h["size"] for h in st.session_state.holes)
st.markdown("---")
st.metric("Total Memory", f"{st.session_state.total_memory} units")
st.metric("Used Memory", f"{total_alloc} units")
st.metric("Free Memory", f"{total_free} units")

