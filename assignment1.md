#### course management system
------------
> Student:
- data:
name,studentEmail,password,id
- behavior:
login,logout,passwordChange,viewCourse,searchCourse,
viewNotification,viewGrade,askForHelp,evaluateTeacher,evaluateTA,
submitAssignment,downloadLearningMaterial

> Teacher:
- data:
name,teacherEmail,password,id
- behavior:
login,logout,passwordChange,viewCourse,sendNotification,viewNotification,
setAssignmentGrade,setLearningMaterial,askForHelp

> TA:
- data:
name,taEmail,password,id
- behavior:
login,logout,passwordChange,viewCourse,sendNotification,viewNotification,
setLearningMaterial,askForHelp,setAssignmentGrade

> Admin:
- data:
name,adminEmail,password,id
- behavior:
login,logout,passwordchange,sendNotification,viewNotification,createAccount,
deleteAccount,modifyAccount

> Course:
- data: courseName,courseCredit,courseTime,teacherName,teacherEmail,taEmail,Grade,classroomNumber,  courseVolume,studentNumber
- behavior: 

> Notification:
- data:
title,subject,content
- behavior:

> LearningMaterial:
- data:
name,subject,fileSize
- behavior:

> ##### Sequence of invoking behaviors on objects
```
    Student ben
    Teacher siva
    TA sun
    Course iNFO5100
    Admin administrator
    Notification news
    LearningMaterial javaBook
    //student's behavior
    if ben.login(id,password)
		while(True)
    		if ben wants to view course information
    			ben.searchCourse(courseName)
    			ben.viewCourse(courseName)
    		else if ben wants to evaluate
    			ben.evaluteTA(sun)
    			ben.evaluteTeacher(siva)
    		else if ben wants to view notification
    			ben.viewNotification(news)
    		else if there is a ben's notification
    				ben.viewGrade(iNFO5100)
    		else if ben wants to download learning Material:
    			ben.downloadLearningMaterial(javaBook)
    		else if ben wants to submit assignment
    			ben.submitAssignment(file)
    		else
    			ben.logout()
				break
    else
    	askForHelp(administrator)
    //teacher's behavior
    if siva.login(id,passowrd)
		while(true)
			if siva wants to view course information
				siva.viewCourse(iNFO5100)
			else if siva wants to see and send notification
				siva.viewNotification(news)
				siva.sendNotification(news)
			else if siva wants to grade ben's assignment
				siva.setAssgnmentGrade(ben)
			else if siva wants to upload learning material named javaBook
				siva.setLearningMaterial(javaBook)
			else 
				siva.logout()
				break
    else
    	siva.askForHelp(Administrator)
    //TA's behavior
    if sun.login(id,passowrd)
		while(true)
			if sun wants to view course information
				siva.viewCourse(iNFO5100)
			else if sun wants to see and send notification
				sun.viewNotification(news)
				sun.sendNotification(news)
			else if sun wants to grade ben's assignment
				sun.setAssgnmentGrade(ben)
			else if sun wants to upload learning material named javaBook
				sun.setLearningMaterial(javaBook)
			else 
				sun.logout()
				break
    else
    	sun.askForHelp(Administrator)
    //Admin's behavior
    administrator.login(id,password)
    administrator.viewNotification(news)
    if one wants to create account
    	administrator.createAccount(id,password)
    if one wants to delete his account
    	administrator.deleteAccount(id,password)
    if one wants to modify his account
    	administrator.modifyAccount(id,pawword)
```


#### pet adoption platform
---------
> Adopter:
- data:
id,password,name,email,phonenumber
- behavior:
login,logout,setInfo,changePassword,searchpet,adopt,askForHelp

> Worker:
- data:
id,password,name,email,phonenumber
- behavior:
login,logout,setInfo,changePassword,sendNotification,askForHelp

> Admin:
- data:
id,password,name,email,phonenumber
- behavior:
login,logout,sendNotification,viewNotification,createAccount,deleteAccount

> Pet:
- data:
name,species,age,sex,healthCondition
- behavior:

> ##### Sequence of invoking behaviors on objects
```
	Adopter ben
    Worker lei
    Admin lucy
    Pet mew
    //Adopter's behavior
    ben.login(id,password)
    if ben wants to modify his information
    	ben.setInfo()
    else if ben wants to search information about cat
    	ben.search(cat)
    	if ben wants to adopt 'mew':
    		ben.adopt(mew)
    	else
    		ben.logout()
    else
    	ben.askForHelp()
    //Worker's behavior
    lei.login(id,password)
    if lei wants to send massage on platform about 'mew'
    	lei.sendNotification(mew)
    else if lei wants to modify his information
    	lei.setInfo()
    else if he need administrator's help about platform
    	lei.askForHelp()
    else
    	lei.logout()
    //Admin's behavior
    lucy.login(id,password)
    if she needs to modify users' account
    	lucy.createAccount(id,name)
    	lucy.deleteAccount(id,name)
    else if she needs to send or view notification about platform
    	lucy.sendNotification(content)
    	lucy.viewNotification(content)
```

#### app to book airline ticket
---------
> Customer:
- data:
name,id,password,phoneNumber,email
- behavior:
login,logout,requestCancelOrder,pay,writeReview,searchTicket,viewTicketDetail

> Order:
- data:
orderNumber,flightNumber,startPoint,destination,flightTime,price
- behavior:

> airlineCompany:
- data:
name,id,password,phoneNumber,email
- behavior:
login,logout,processOrder,setDiscount,pay

> ##### Sequence of invoking behaviors on objects
```
    Customer ben
    Order beijing2Seattle
    airlineCompany unionAirlines
    ben.login(id,password)
    if ben wants to leave Beijing to Seattle by air:
    	ben.searchTicket('beijing','seattle')
    	unionAirlines.setDiscount('beijing','seattle')
    	ben.viewTicketDetail()
    	if ben decide to buy the ticket
    		ben.requestCancelOrder()
    		ben.pay()
		    if unionAirlines.processOrder(beijing2Seattle):
				unionAirlines.sendMessage('Success')
			else
			    unionAirlines.sendMessage('FailtoOrder')
				ben.requestCancelOrder()  //ben will cancel the order
				unionAirlines.pay(ben)
			
    if ben wants to write review after flight
    	ben.writeReview('Nice flight')
```

#### course registration platform
------
> Student:
- data:
studentName,studentEmail,studentPassword,studentId
- behavior:
registerCourse,dropCourse,viewCourse,searchCourse,viewRegisterTutorial

> Course:
- data:
className,teacherName,roomNumber,courseNumber,time,subject,volumn,
RequiredOrElectiveClass,courseDetail
- behavior:

> Administrator:
- data:
adminName,adminEmail,adminPassword,adminId
- behavior:
login,logout,createAccount,deleteAccount,modifyAccount,
creatCourse,deleteCourse,modifyCourseInfo

> ##### Sequence of invoking behaviors on objects
```
	Student ben
    Course iNFO5100
    Administrator admin

    ben.login(studentId,studentPassword)
    if ben needs some help:
    	ben.viewRegisterTutorial()
    else if ben wants to register INFO5100
    	ben.searchCourse('INFO5100')
    	ben.viewCourse(iNFO5100)
    	ben.registerCourse()
    else if ben wants to drop INFO5100
    	ben.dropCourse(iNFO5100)
    //administrator's behavior
    admin.login(adminId,adminPassword)
    if admin needs to create, delete or modify students account
    	admin.createAccount(studentID,studentPassword)
    	admin.deleteAccount(studentID,studentPassword)
    	admin.modifyAccount(studentID,studentPassword)
    else if admin needs to create, delete or modify one course
    	admin.createCourse(Course)
    	admin.deleteCourse(Course)
    	admin.modifyCourse(Course)
    else
    	admin.logout()
```

#### Order food in a food delivery app
-------
> Customer:
- data:
name,id,password,address,phoneNumber,creditCard
- bahavior:
login,requestCancelOrder,pay,searchFood,viewFoodDetail,writeReview,modifyInfo

> Food:
- data:
foodName,picture,price,weight
- behavior:

> App:
- data:
orderID,orderTime
- behavior:
sendReceipt,allocateCourier,checkout,refund

> Shop:
- data:
shopName,phoneNumber,address,FoodName
- behavior:
receiveReceipt,contactCourier,contactCustomer,makeFood

> Courier:
- data:
name,phoneNumber
- bahavior:
deliverFood,contactCustomer

> ##### Sequence of invoking behaviors on objects
```
    Customer ben
    Food taco
    App app
    Shop mexicanRestaurant
    Courier Bob
    ben.login(id,password)
	if ben needs to modify his information like address or something
		ben.modifyInfo()
    if ben wants to eat taco:
    	ben.searchFood('taco')
    	ben.viewFoodDetail(taco)
    	if ben wants to order taco from mexicanRestaurant:
    		ben.requestCancelOrder(taco,mexicanRestaurant)
    		ben.pay()
    		app.sendReceipt()
    		app.allocateCourier()
    		mexicanRestaurant.receiveRecepit()
			if workers from mexicanRestaurant needs to contact with Courier:
    			mexicanRestaurant.contactCourier()
			if workers from mexicanRestaurant needs to contact with ben bacause of taco out of stock:
    			mexicanRestaurant.contactCustomer()
				ben.RequestCancelOrder(taco,mexicanRestaurant)
				app.refund(ben)
    		mexicanRestaurant.makeFood(taco)
    		Bob.deliverFood(app)
    		Bob.contactCustomer(ben)
	if ben wants to write review after having taco:
		ben.writeReview('Delicious!')
```