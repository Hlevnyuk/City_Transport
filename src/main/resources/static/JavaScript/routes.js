const routeInBtn = document.querySelector('.route-btn');
const stopInBtn = document.querySelector('.stop-btn');
const formBox = document.querySelector('.form-box');
const body = document.body;
stopInBtn.addEventListener('click', function() {
    formBox.classList.add('active');
    body.classList.add('active');
});
routeInBtn.addEventListener('click', function() {
    formBox.classList.remove('active');
    body.classList.remove('active');
});