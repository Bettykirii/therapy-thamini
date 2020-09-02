
fetch("http://localhost:8080/finances/finance",{
	method:'GET',
	headers:{'Content-Type':'application/json'}
})

	.then((response) => response.json())
	.then((data) => {

        data.forEach(element => {
			const table = document.querySelector("#dashboard");
            const id =element.id;
            const AccNo=element.accNo;
            const Amount=element.amount;

  console.log(element);
            const row = `
            <tr>
			<td>${id}</td>
			<td>${AccNo}</td>
			<td>${Amount}</td>
			</tr> `;

			table.insertAdjacentHTML("beforeend",row)

		});


	}).catch((error)=>{
		console.log('There is an error')
	})
