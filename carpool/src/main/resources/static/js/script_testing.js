document.addEventListener('DOMContentLoaded', function() {
    const overlay = document.querySelector('.overlay');
    const loginlink = document.querySelector('.login-link');
    const registerlink = document.querySelector('.register-link');
    const loginForm = document.querySelector('.form-box.login');
    const wrapper = document.querySelector('.wrapper'); // Define the 'wrapper' variable here

    if (loginlink && registerlink && loginForm && wrapper) {
        registerlink.addEventListener('click', () => {
            wrapper.classList.add('active');
            if (overlay) {
                overlay.style.display = 'none';
            }
        });

        loginlink.addEventListener('click', () => {
            wrapper.classList.remove('active');
            if (overlay) {
                overlay.style.display = 'none';
            }
        });
    }
});
