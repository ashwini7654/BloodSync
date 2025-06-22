document.addEventListener("DOMContentLoaded",async()=>{
	try{
		let requestTable=document.getElmentById("requestTableBody")
		let  response=await fetch("http://localhost:7654/Project-BloodSync/ManageBloodRequestServlet");
		let data= await response.json();
		console.log(data);
		
		
		data.forEach((request)=>{
			let action;
			if(datrequest.status==='failed'){
						throw new Error(data.message);
					}
					if(request.status==='Pending'){
						action=`<td><button class="reject">Reject</button><button class="approve">Approve</button></td>`;
					}else{
						action="<td>Not applicable</td>";
					}
			let row=`<tr><td>${request.requestId}</td>
			             <td>${request.hospitalName}</td>
						 <td>${request.bloodType}</td>
						 <td>${request.requestedUnits}</td>
						 <td>${request.urgency}</td>
						 <td>${request.status}</td>
						 <td>${request.requestDate}</td>
						 <td>${action}</td>
						 </tr>`
						 requestTable.innerHTML+=row;
		})
	}catch(error){
		console.log(error)
	}
});