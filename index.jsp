<!DOCTYPE html>
<html>
<head>
    <style>
table {
  font-family: arial, sans-serif;
  border-collapse: collapse;
  width: 100%;
}

td, th {
  border: 1px solid #dddddd;
  text-align: left;
  padding: 8px;
}

thead:nth-child(even) {
  background-color: #dddddd;
}
</style>
</head>
<body>

<h2>Transaction Details</h2>
<table id="dashboard">
    <thead>
    <tr>
        <th>Id</th>
        <th>Account Number</th>
        <th>Amount</th>
    </tr>
    </thead>
    <tbody>
    <tr>
        <td data-column="Id">1</td>
        <td data-column="Account Number">67890</td>
        <td data-column="Amount">4500</td>
    </tr>
    </tbody>
</table>
<script src="main.js"></script>
</body>
</html>
