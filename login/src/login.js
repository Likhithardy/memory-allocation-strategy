import './App.css';


import React from 'react';
import { BrowserRouter as Router, Routes, Route, Link } from 'react-router-dom';

import Login from './login';
import Register from './register';

function App() {
  return (
    <Router>
      <div>
        <h1>Login and Register App</h1>
        <nav>
          <Link to="/">Login</Link> | {' '}
          <Link to="/register">Register</Link>
        </nav>
        <Routes>
          <Route path="/" element={<Login />} />
          <Route path="/register" element={<Register />} />
        </Routes>
      </div>
    </Router>
  );
}

export default App;