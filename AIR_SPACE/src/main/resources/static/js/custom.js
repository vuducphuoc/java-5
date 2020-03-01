
$(document).ready(function() {
    $('#inputSearch').focus(function() {
        $('#formSearch').css({
            background : '#FFF',
        });
    });

    $('#inputSearch').blur(function() {
        $('#formSearch').css({
            background : '#DFDFDF',
        });
    });

    $('#btnLogout').click(function () {
        $.ajax({
            url: 'api/logout',
            type: 'POST',
            data: {},
            success: function (value) {
                var url = window.location.href;
                window.location.href = url;
            }
        });
    });
});

(function() {
    'use strict';
    window.addEventListener('load', function() {
        // Fetch all the forms we want to apply custom Bootstrap validation styles to
        var forms = document.getElementsByClassName('needs-validation');
        // Loop over them and prevent submission
        var validation = Array.prototype.filter.call(forms, function(form) {
            form.addEventListener('submit', function(event) {
                if (form.checkValidity() === false) {
                    event.preventDefault();
                    event.stopPropagation();
                }
                form.classList.add('was-validated');
            }, false);
        });
    }, false);
})();







