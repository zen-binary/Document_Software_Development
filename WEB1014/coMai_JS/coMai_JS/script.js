function luyThua () {
    var a = Number(prompt("Xin mời bạn nhập số a: "))
    var b = Number(prompt("Xin mời bạn nhập số b: "))
    alert(Math.pow(a,b))

}
function heron () {
    var a = Number(prompt("Xin mời bạn nhập số a: "))
    var b = Number(prompt("Xin mời bạn nhập số b: "))
    var c = Number(prompt("Xin mời bạn nhập số c: "))
    var p = (a+b+c)/2
    var s = Math.sqrt(p*(p-a)*(p-b)*(p-c))
    alert("Diện tích hình tam giác đó: "+ s)
    
}