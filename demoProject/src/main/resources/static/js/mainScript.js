$(document).ready(function () {
  console.log("Hello World!");
});
// Accordion
function myFunction(id) {
  var x = document.getElementById(id);
  if (x.className.indexOf("w3-show") == -1) {
    x.className += " w3-show";
    x.previousElementSibling.className += " w3-theme-d1";
  } else { 
    x.className = x.className.replace("w3-show", "");
    x.previousElementSibling.className = 
    x.previousElementSibling.className.replace(" w3-theme-d1", "");
  }
}

// Used to toggle the menu on smaller screens when clicking on the menu button
function openNav() {
  var x = document.getElementById("navDemo");
  if (x.className.indexOf("w3-show") == -1) {
    x.className += " w3-show";
  } else { 
    x.className = x.className.replace(" w3-show", "");
  }
}

function addPost(){
 var postdesc = $('#postdesc').text()
const start = Date.now();
var date = new Date();

var userNm = $('#userNm').text()

   $.ajax({
               url: "/public/newPost",
               type: "POST",
               dataType:"json",
               data: JSON.stringify({
                                         postDesc : postdesc,
                                         postTime : date.toLocaleDateString(),
                                         postBy : userNm,
                                         postLike : 2,
                                         postCmnt: "hii,hhiii,hhijd"

                                      }),
               contentType: "application/json",
               success: function(got) {
                    alert("Data: " + got);
                  }
            });
  var html='';
 $(".postContent").append(`<div class="w3-container w3-card w3-white w3-round w3-margin"><br>
                                        <img src="/images/img_avatar.png" alt="Avatar" class="w3-left w3-circle w3-margin-right" style="width:60px">
                                        <span class="w3-right w3-opacity">${Date.now() - start} ms</span>
                                        <h4>${userNm}</h4><br>
                                        <hr class="w3-clear">
                                        <p>${postdesc}</p>

                                        <button type="button" class="w3-button w3-theme-d1 w3-margin-bottom"><i class="fa fa-thumbs-up"></i>  Like</button>
                                        <button type="button" class="w3-button w3-theme-d2 w3-margin-bottom"><i class="fa fa-comment"></i>  Comment</button>
                                      </div>`)



}