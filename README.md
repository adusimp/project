Javascript :
-Khai báo biến , cú pháp, câu lệnh, hàm và sư kiện  

  +code sample : bài tập máy tính đơn giản.
   ```
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
   ```
  + code sample : bài tập todolist.
```
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
```
-Object,Array, for...in ,for...of:

  +code sample: bài tập quản lí sinh viên (thêm,xóa,sắp xếp theo tên)
  
  ```
    <body>
    <label for="">Tên: </label>
    <input type="text" id="name"><br>
    <label for="">Tuổi: </label>
    <input type="text" id="age"><br>
    <label for="">SDT: </label>
    <input type="text" id="phone"><br>
    <label for="">Dia chi: </label>
    <input type="text" id="address"><br>
    <button onclick="myFunction()" id="them">Thêm</button>
    <button onclick="myFunction()" id="sort">Sắp xếp theo tên</button><br>
    <table id="bang" border="1">
        <thead>
            <tr>
                <th>Name</th>
                <th>Age</th>
                <th>Phone</th>
                <th>Address</th>
            </tr>
        </thead>
        <tbody id="contentbang">

        </tbody>
    </table>
    <p id="demo"></p>
    <script>
        const ds = []
        function Sinhvien(name, age, phone, address) {
            this.name = name;
            this.age = age;
            this.phone = phone;
            this.address = address;
        }
        function addSv(sv) {
            ds.push(sv);
            var content = document.getElementById("contentbang");
            const row = content.insertRow();
            for (const key in sv) {
                row.insertCell().textContent = sv[key];
            }
            const btn = document.createElement("button");
            btn.textContent = "Xóa";
            btn.onclick = function () {
                content.deleteRow(row.rowIndex);
            };
            row.insertCell().appendChild(btn);
            document.getElementById("demo").innerHTML= ds[0].name;
        }
        function sortbyName() {
            ds.sort(function(a,b){
                let x = a.name.toLowerCase();
                let y = b.name.toLowerCase();
                if (x<y) {return -1;}
                if (x<y) {return 1;}
                return 0;
            });
            document.getElementById("contentbang").innerHTML = "";
            var contentbang = document.getElementById("contentbang");
            for (const sv of ds) {
                const row = contentbang.insertRow();
                document.getElementById("demo").innerHTML= sv.name;
                for (let key in sv) {
                    row.insertCell().textContent = sv[key];
                }
                const btn = document.createElement("button");
                    btn.textContent = "Xóa";
                    btn.onclick = function () {
                        contentbang.deleteRow(row.rowIndex);
                        ds.pop()
                    };
                    row.insertCell().appendChild(btn);
            }
        }
        function myFunction() {
            const element = document.activeElement.id
            switch (element) {
                case 'them':
                    var name = document.getElementById("name").value;
                    var age = document.getElementById("age").value;
                    var phone = document.getElementById("phone").value;
                    var address = document.getElementById("address").value;
                    const sv = new Sinhvien(name, age, phone, address);
                    addSv(sv)
                    break;
                case 'sort':
                    sortbyName();
                    break;
            }

        }
    </script>
</body>
  ```
