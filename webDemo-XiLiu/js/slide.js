var currentImage = 1;
var imageCount = 4;
window.onload = function () {
  //2秒后执行
  setTimeout(selfChangeImage, 2000);
};

//1、找到container下的所有img标签,li标签,左右按钮
var aImgs = document.querySelectorAll(".container img");
var aLis = document.querySelectorAll(".container li");
var btnLeft = document.querySelector(".container .left");
var btnRight = document.querySelector(".container .right");
//点击事件
//点击按钮图片切换
var index = 0; //当前图片下标
var lastIndex = 0;
btnRight.onclick = function () {
  //记录上一张图片的下标
  lastIndex = index;
  //清除上一张图片的样式
  aImgs[lastIndex].className = "";
  aLis[lastIndex].className = "";
  index++;
  index %= aImgs.length; //实现周期性变化
  //设置当前图片的样式
  aImgs[index].className = "on";
  aLis[index].className = "active";
};
//左边按钮类似
btnLeft.onclick = function () {
  //记录上一张图片的下标
  lastIndex = index;
  //清除上一张图片的样式
  aImgs[lastIndex].className = "";
  aLis[lastIndex].className = "";
  index--;
  if (index < 0) {
    index = aImgs.length - 1;
  }
  //设置当前图片的样式
  aImgs[index].className = "on";
  aLis[index].className = "active";
};

//自动循环
function selfChangeImage() {
  if (currentImage < imageCount) {
    currentImage++;
  } else if ((currentImage = imageCount)) {
    currentImage = 1;
  }

  var imageObj = document.getElementById("test");
  imageObj.src = "images/slidePic" + currentImage + ".png";
  //2秒后执行
  setTimeout(selfChangeImage, 2000);
}
