# WishList Managment
Local Setup Guide
Prerequisites
Before you begin, ensure that you have the following installed:

1. Java Development Kit (JDK)

2. Springboot

3. Maven

4. JUnit


[Dependency]-
1. h2 database
2. Spring Security
3. Spring web
# other dependency download from pom.xml


Clone the Repository

git clone https://github.com/Ajaypratap4015/WishListManagment.git


cd your-repo



# Build the Project

mvn clean install


# Run the Application


mvn spring-boot:run
The application will start on http://localhost:8080. 

You can access the API from Postman and use CRUD operation


#About Project


User can register / log in.
User can add/delete/read wishlist
User can add/delete/read wishlist Item
User have to insert token for user authenthication

#Unit Test

User can use code:

mvn test

or in IntelliJ Right Click the project and select Run all test cases.


# Screenshots

POST Register
![Screenshot (211)](https://github.com/Ajaypratap4015/WishListManagment/assets/68500595/236da3f4-f3bb-41f1-97e8-781b35811816)


POST Login
![Screenshot (212)](https://github.com/Ajaypratap4015/WishListManagment/assets/68500595/ad3ee353-086a-4f00-ba29-e2f1f574e25b)


POST CreateWishList
![Screenshot (213)](https://github.com/Ajaypratap4015/WishListManagment/assets/68500595/5d40a605-7c2e-4948-9790-7b242104d827)


GET UserWishlist
![Screenshot (214)](https://github.com/Ajaypratap4015/WishListManagment/assets/68500595/9cf6ebcb-59b8-4ffc-9e8d-6ce95a79c08a)


DELETE RemoveWishlist
![Screenshot (215)](https://github.com/Ajaypratap4015/WishListManagment/assets/68500595/9cd21cda-e9ff-4e50-b213-3e582870cbf4)


POST CreateWishlistItem

![Screenshot (216)](https://github.com/Ajaypratap4015/WishListManagment/assets/68500595/212ac52e-94bf-408b-8378-45b079337256)


DELETE RemoveWishListItem

![Screenshot (217)](https://github.com/Ajaypratap4015/WishListManagment/assets/68500595/db8f3d99-874e-4e4a-94a2-1405c442186d)


GET AllItemInWishlist

![Screenshot (218)](https://github.com/Ajaypratap4015/WishListManagment/assets/68500595/b984ad91-42e4-4015-a434-21f2ca8492c0)

