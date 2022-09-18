$("#submitBtn").on("click", function (event) {
    var form = new FormData();
    form.append("name", $("#name").val());
    form.append("email", $("#email").val());
    form.append("mobile", $("#mobile").val());
    form.append("message", $("#message").val());

    $("#submitBtn").addClass("d-none");
    $("#loader").removeClass("d-none");

    $.ajax({
        type: "post", url: "SendEmail", data: $(".form").serialize(), success: function (result) {
            $("#submitBtn").removeClass("d-none");
            $("#loader").addClass("d-none");

            if (result == "success") {
                $("#name").val("");
                $("#email").val("");
                $("#mobile").val("");
                $("#message").val("")
                new bootstrap.Toast($("#liveToast")).show();
            } else {
                alert(result);
            }
        }
    });

})

$(".form").submit(function (e) {
    e.preventDefault();
});