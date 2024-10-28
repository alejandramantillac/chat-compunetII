// Renderiza el msg en el componente Message

const Message = ({ message, isSent }) => {
    return (
        <div className={`message ${isSent ? 'sent' : 'received'}`}>
            <strong>{message.sender}: </strong>{message.content}
        </div>
    );
}

export default Message;