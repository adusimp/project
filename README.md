Javascript :
-Khai báo biến , cú pháp, câu lệnh, hàm và sư kiện  
  +code sample : bài tập máy tính đơn giản.
    <body>
    <input id="n1" type="text"><br>
    <p id="op"></p><br>
    <input id="n2" type="text"><br>
    <p>=</p><br>
    <p id="rs"></p>
    <button id="+" onclick="myFunction()" >+</button  >
    <button id="-" onclick="myFunction()" >-</button  >
    <button id="*" onclick="myFunction()" >*</button  >
    <button id="/" onclick="myFunction()" >/</button>
    <script>
        function myFunction(){
            const element = document.activeElement.id;
            var n1 = parseFloat(document.getElementById("n1").value);
            var n2 = parseFloat(document.getElementById("n2").value);
            var rs;
            switch(element){
                case '+':
                    rs = n1 + n2;
                    break;
                case '-':
                    rs = n1 - n2;
                    break;
                case '*':
                    rs = n1 * n2;
                    break;
                case '/':
                    rs = n1 / n2;
                    break;
            }
            document.getElementById("rs").innerHTML=rs;
        }
    </script>
</body>
  + code sample : bài tập todolist.
    <body>
    
        <input type="text" id="val">
        <input type="submit" value="submit" onclick="myFunction()">
    
    <select name="todolist" id="sl1" style="width: 100px;" >
        
    </select>
</body>
<script>
    function myFunction(){
        var x = document.getElementById("val").value;
        var todolist = document.getElementById("sl1")
        var li = document.createElement("option")
        li.innerHTML=x
        todolist.add(li)
    }
</script>
    
