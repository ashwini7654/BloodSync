document.addEventListener("DOMContentLoaded" ,async()=>{
	try{
		let stockTable=document.getElementById("stockTableBody")
		let response=await fetch("http://localhost:7654/Project-BloodSync/ManageBloodStockServlet");
		let data=await response.json();
		console.log(data);
		data.forEach((stock)=>{
			let row=`<tr><td>${stock.bloodType}</td>
			             <td>${stock.availableUnits}</td>
						 <td>${stock.donatedUnits}</td>
						 <td>${stock.totalUnits}</td>
						 </tr>`
						 stockTable.innerHTML+=row;
		})
	}catch(Error){
		console.log(Error);
	}
})