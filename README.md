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
![Screenshot (211)](https://github.com/Ajaypratap4015/WishListManagment/assets/68500595/d23f0e97-741e-4a3a-9b3a-210bb7e89606)


POST Login
![Screenshot (212)](https://github.com/Ajaypratap4015/WishListManagment/assets/68500595/2e08f81e-ba88-4fd1-8881-b4347c4503ad)



POST CreateWishList
![Screenshot (213)](https://github.com/Ajaypratap4015/WishListManagment/assets/68500595/358de121-9bbc-4a04-9fb7-236cb4fe1e72)



GET UserWishlist

![Screenshot (214)](https://github.com/Ajaypratap4015/WishListManagment/assets/68500595/24d588af-2a99-47ea-9bd3-881c163ff9aa)


DELETE RemoveWishlist

![Screenshot (215)](https://github.com/Ajaypratap4015/WishListManagment/assets/68500595/ddf4bb35-c158-46b0-bc3d-2ca5b4fb38dc)


POST CreateWishlistItem
![Screenshot (216)](https://github.com/Ajaypratap4015/WishListManagment/assets/68500595/880124b9-3567-4466-a9f9-0d7a0638dfa4)



DELETE RemoveWishListItem
![Screenshot (217)](https://github.com/Ajaypratap4015/WishListManagment/assets/68500595/0f06390c-4a4d-4913-8fc8-110e51f46d38)



GET AllItemInWishlist

![Screenshot (218)](https://github.com/Ajaypratap4015/WishListManagment/assets/68500595/41aedb50-ade4-4df5-9959-b19c30b6d84b)

