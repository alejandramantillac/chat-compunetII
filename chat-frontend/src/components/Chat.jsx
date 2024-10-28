import { useEffect, useState, useRef } from 'react';
import stompService from '../utils/stompService';
import Message from './Message';
import '../App.css'; 

const Chat = ({ username }) => {
    const [messages, setMessages] = useState([]);
    const [recipient, setRecipient] = useState('');
    const [messageContent, setMessageContent] = useState('');
    const [errorMessage, setErrorMessage] = useState('');
    const subscriptionRef = useRef(null);

    useEffect(() => {
        if (username && !subscriptionRef.current) {
            stompService.subscribe(`/messageTo/user/${username}`, (message) => {
                setMessages((prevMessages) => [...prevMessages, message]);
            }).then(subscription => {
                subscriptionRef.current = subscription;
            }).catch(console.log);
        }

        return () => {
            if (subscriptionRef.current) {
                subscriptionRef.current.unsubscribe();
                subscriptionRef.current = null;
            }
        };
    }, [username]);

    const sendMessage = () => {
        if (recipient && messageContent) {
            const newMessage = { content: messageContent, sender: username };
            stompService.publish(`/messageTo/user/${recipient}`, newMessage);
            setMessages((prevMessages) => [...prevMessages, { ...newMessage, isSent: true }]);
            setMessageContent('');
            setErrorMessage('');
        } else {
            setErrorMessage('All fields are required to send a message');
        }
    };

    return (
        <div className="centered-container">
            <div>
                <h1 className='centered-header'> Messages - Chat </h1>
                <input
                    type="text"
                    value={recipient}
                    onChange={(e) => setRecipient(e.target.value)}
                    placeholder="Enter recipient username"
                />
                <input
                    type="text"
                    value={messageContent}
                    onChange={(e) => setMessageContent(e.target.value)}
                    placeholder="Enter your message"
                />
                <button onClick={sendMessage}>Send</button>
                {errorMessage && <p style={{ color: 'red' }}>{errorMessage}</p>}
                <div className="messages-container">
                    {messages.map((message, index) => (
                        <Message key={index} message={message} isSent={message.isSent} />
                    ))}
                </div>
            </div>
        </div>
    );
}

export default Chat;