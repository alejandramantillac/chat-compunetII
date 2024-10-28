import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';
import '../App.css';

const Register = ({ onRegister }) => {
    const [username, setUsername] = useState('');
    const [error, setError] = useState('');
    const navigate = useNavigate();

    const registerUser = () => {
        if (!username) {
            setError('Username is required');
            return;
        }

        setError('');
        alert('User registered successfully');
        onRegister(username);
        navigate('/chat');
    };

    return (
        <div className="centered-container">
            <div>
                <h1 className='centered-header'>Register User</h1>
                <input
                    type="text"
                    value={username}
                    onChange={(e) => setUsername(e.target.value)}
                    placeholder="Enter username"
                />
                <button onClick={registerUser}>
                    Register
                </button>
                {error && <p style={{ color: 'red' }}>{error}</p>}
            </div>
        </div>
    );
};

export default Register;