<html>
<head>
    <title>Student Result Form</title>

    <script>
        function validateForm() {
            let roll = document.forms["studentForm"]["rollno"].value;
            let name = document.forms["studentForm"]["name"].value;
            let marks = [];

            for (let i = 1; i <= 5; i++) {
                marks[i] = document.forms["studentForm"]["sub" + i].value;

                if (marks[i] === "" || marks[i] < 0 || marks[i] > 100) {
                    alert("Enter valid marks (0-100) for all subjects!");
                    return false;
                }
            }

            if (roll === "" || name === "") {
                alert("Roll number and name are required!");
                return false;
            }

            return true;
        }
    </script>
</head>

<body>
    <h2>Student Marks Entry</h2>

    <form name="studentForm" action="ResultServlet" method="post" onsubmit="return validateForm()">
        Roll No: <input type="text" name="rollno"><br><br>
        Name: <input type="text" name="name"><br><br>

        Subject 1: <input type="number" name="sub1"><br><br>
        Subject 2: <input type="number" name="sub2"><br><br>
        Subject 3: <input type="number" name="sub3"><br><br>
        Subject 4: <input type="number" name="sub4"><br><br>
        Subject 5: <input type="number" name="sub5"><br><br>

        <input type="submit" value="Calculate Result">
    </form>
</body>
</html>