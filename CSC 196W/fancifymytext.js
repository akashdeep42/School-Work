var textarea=document.getElementById("textarea");
function big(){
    textarea.style.fontSize="24pt";
}
document.getElementsByName("fancify")[0].addEventListener("change",function(){
    textarea.style.fontWeight="bold";
    textarea.style.color="blue";
    textarea.style.textDecoration="underline"
    alert("This text has been Fancified");
})
document.getElementsByName("fancify")[1].addEventListener("change",function(){
    textarea.style.fontWeight="normal";
    textarea.style.color="black";
    textarea.style.textDecoration="none"
    alert("This text has been unfancified");
})
function moo(){
    textarea.style.textTransform="uppercase"
    let x=textarea.value.split(".");
    let i=x.join("-Moo");
    textarea.value=i;
}