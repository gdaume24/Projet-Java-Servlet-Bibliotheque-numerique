window.addEventListener('DOMContentLoaded', () => {
    // sélectionne tous les éléments avec la classe 'notification'
    const notifications = document.getElementsByClassName('notification');
    
    // convertit le HTMLCollection en array pour pouvoir itérer avec forEach
    Array.from(notifications).forEach(notification => {
        setTimeout(() => {
            notification.style.opacity = '0';
            setTimeout(() => {
                notification.remove();
            }, 1000);
        }, 3000);
    });
});
