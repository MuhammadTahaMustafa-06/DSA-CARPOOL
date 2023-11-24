const wrapper = document.querySelector('.wrapper');
const loginlink = document.querySelector('.login-link');
const registerlink = document.querySelector('.register-link');
const loginForm = document.querySelector('.form-box.login');
const overlay = document.querySelector('.overlay');

registerlink.addEventListener('click', () => {
    wrapper.classList.add('active');
    overlay.style.display = 'none';
});

loginlink.addEventListener('click', () => {
    wrapper.classList.remove('active');
    overlay.style.display = 'none';
});

// Event listener for the login form submission
loginForm.addEventListener('submit', (e) => {
    e.preventDefault();

    // Placeholder for your authentication logic
    const isValidCredentials = true;  // Replace this with your actual authentication logic

    if (isValidCredentials) {
        // Redirect to the menu page after successful login
        window.location.href = 'menu_login.html';
    } else {
        // Handle invalid credentials (show error message, etc.)
        alert('Invalid credentials. Please try again.');
    }
});
