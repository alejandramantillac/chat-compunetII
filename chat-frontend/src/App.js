import React, { useState } from 'react';
import { BrowserRouter as Router, Route, Routes, Navigate } from 'react-router-dom';
import Register from './components/Register';
import Chat from './components/Chat';

const App = () => {
  const [username, setUsername] = useState('');

  const handleRegister = (username) => {
    setUsername(username);
  };

  return (
    <Router>
      <Routes>
        <Route path="/" element={<Navigate to="/register" />} />
        <Route path="/register" element={<Register onRegister={handleRegister} />} />
        <Route path="/chat" element={<Chat username={username} />} />
      </Routes>
    </Router>
  );
};

export default App;