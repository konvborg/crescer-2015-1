function checkFile() {
    var fileElement = document.getElementById("img");
    var fileExtension = "";
    if (fileElement.value.lastIndexOf(".") > 0) {
        fileExtension = fileElement.value.substring(fileElement.value.lastIndexOf(".") + 1, fileElement.value.length);
    }
    if (fileExtension == "png" || fileExtension == "jpg" || fileExtension =="jpeg") {
        return;
    }
    else {
        alert("A imagem deve ser '.png.','.jpeg' ou '.jpg'");
        fileElement.value='';
        return;
    }
}