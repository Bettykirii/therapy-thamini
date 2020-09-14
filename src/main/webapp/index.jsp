<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <meta http-equiv="x-ua-compatible" content="ie=edge" />

    <title>Thamini | Clients</title>

     <link rel="stylesheet" href="Css/main.css">

    <style>
      .wrapper {
        text-align: center;
      }
      table {
        width:100%;
      }
      table, th, td {
        border: 1px solid black;
        border-collapse: collapse;
      }
      th, td {
        padding: 15px;
        text-align: left;
      }
      #dashboard tr:nth-child(even) {
        background-color: #eee;
      }
      #dashboard tr:nth-child(odd) {
       background-color: #fff;
      }
      #dashboard th {
        background-color: black;
        color: white;
      }
    </style>
  </head>

  <body class="hold-transition sidebar-mini">
    <div class="wrapper">
      <!-- Navbar -->
      <jsp:include page="nav.html" />
      <!-- /.navbar -->

      <!-- Main Sidebar Container -->
      <jsp:include page="nav.html" />
      <!-- /.Main Sidebar Container -->

      <main class="main">
        <div class="main-header">
          <div class="main-header__heading">Hello Username</div>
          <div class="main-header__updates">
            <!--                <div class="box">-->
            <!--                  <a class="button" href="#popup1">ADD</a>-->
            <!--                </div>-->
            <button><a href="#ex1" rel="modal:open">ADD-TENANT</a></button>
          </div>
        </div>
        <div id="ex1" class="modal">

          <div class="content" >
            <form action="<%=request.getContextPath()%>/display_clients" method="POST">
              <input placeholder="Name" name="firstName" type="text" required />
              <input placeholder="House_No" name="lastName" type="text" required />
              <input placeholder="Rent_Paid" name="username" type="prize" required />
              <input placeholder="Rent_Paid" name="email" type="prize" required />
              <input placeholder="Date" type="size" name="date" required />

            </form>
          </div>
        </div>
        <div class="main-overview">
          <div class="overviewcard">
            <table id="dashboard">
              <thead>
                <tr>
                  <th>firstName</th>
                  <th>lastName</th>
                  <th>username</th>
                  <th>email</th>
                  <th>Date</th>
                  <th>Edit</th>
                  <th>Delete</th>
                </tr>
              </thead>

              <tbody class="rent-table">
                <tr>
                  <td data-column="firstName"></td>
                  <td data-column="lastName"></td>
                  <td data-column="username"></td>
                  <td data-column="email"></td>
                  <td data-column="Date"></td>
                  <td><a href="">Edit</a></td>
                  <td><a href="" id="delete">Delete</a></td>
                </tr>
              </tbody>
            </table>
          </div>
        </div>
      </main>
      <!-- /.content-wrapper -->

      <!-- Control Sidebar -->
      <aside class="control-sidebar control-sidebar-dark">
        <!-- Control sidebar content goes here -->
      </aside>
      <!-- /.control-sidebar -->

      <!-- Main Footer -->

    </div>
    <!-- ./wrapper -->

    <!-- REQUIRED SCRIPTS -->


    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.0.0/jquery.min.js"></script>
    <script>
      // Fetch all users
      fetch("http://localhost:8080/Counselling-webapp/display_clients", {
        method: "GET",
        headers: { "Content-Type": "application/json" },
      })
        .then((response) => response.json())
        .then((data) => {
          console.log("data is:",data)
          data.forEach((element) => {
            const table = document.querySelector("#dashboard");
            const firstName = element.firstName;
            const id = element.id;
            const lastName = element.lastName;
            const username = element.username;
            const email = element.email;
            const date = element.timeRecorded;
            console.log(firstName, lastName, username, email, date);

            const row = `
            <tr>
              <td>${firstName}</td>
              <td>${lastName}</td>
              <td>${username}</td>
              <td>${email}</td>
              <td>${date}</td>
              <td>
              <a href>Edit</a>
              </td>
              <td>
              <button class="delbtn" onclick="delItems(this)" data-id="${id}">Delete</button>
              </td>
            </tr>
            `;
            table.insertAdjacentHTML("beforeend", row);
          });
        })
        .catch((error) => {
          console.log(error, "There is an error");
        });

      //Deleting an item from the database
       function delItems(e) {
        const deleteBtn = document.querySelector(".delbtn");
        console.log(e);
        let xhr = new XMLHttpRequest();

        xhr.open(
          "delete",
          "/counselling-app/display_clients?" + `id=${deleteBtn.dataset.id}`,
          false
        );
        xhr.onload = function () {
          if (xhr.status == 200) {
            alert(xhr.responseText);
          } else {
            alert("Error occurred " + xhr.status);
          }
        };
        xhr.send();
      };
    </script>
  </body>
</html>
