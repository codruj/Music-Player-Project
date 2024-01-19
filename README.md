

<p align="center">
  <a href="#Music_Application">Music Application</a> •
  <a href="#Author">Author</a> •
  <a href="#Description">Description</a> •
  <a href="#Database">Database</a> •
  <a href="#Music_Player">Music Player</a> •
  <a href="#Visuals">Visuals</a> •
  <a href="#Further">Further developments</a>
</p>

# Music_Application 

This Betting Application was made for the OOP 2023/2024 project assignment.

## Author 
Jucan Codruta-Elen | 2nd Year Computer Engineering | Technical University of Cluj-Napoca

## Description
The application was built using Java. The dependencies are:
```bash
jlayer
sql
jdbc
swing
```
In this application, users can listen to several **albums**, **artists**, **songs**, review any album, artist or song they want and see the merch an artist is selling.
There is also an admin that can add genres for artists and that can see all the reviews.
Every type of data (**users**, **admins**, **songs**, **albums** etc.) is stored in a `Postgres SQL Database` which is accessed through an _SQL Connection_ realized by the [jdbc API](https://en.wikipedia.org/wiki/Java_Database_Connectivity) and all the updates to the `Database` is done using the same kind of _Connection_. The data is always fetched again in this way so that the **User** can see updates on music related things, or the **Admin** can see all the reviews.

The **User Interface** part was done using Swing. Every view was code-written (not using Scene Builder).

**Main Classes:**
-
```java
class Song;           //the song can be seen and played by the user with all its details displayed
class Album;             //the album can be seen by the user with all its songs displayed
class Artist;             //the artist can be seen by the user with all its albums and genres displayed
class Merch;        //the user sees all merch characteristics for a product
```
There are also other classes for `SQLConnection`, `View`, `Controller`, `Model`, `Repository` etc.

## Database:
The database is managed by `Postgres SQL` and is fetched using the `jdbc driver`. There are CRUD operations implemented for multiple tables in the data base (for example: creating and deleting the user, adding new genres for an artist).
The diagram:

![image](https://github.com/OOP-Projects-2020-2021/Betting_Application/blob/master/res/diagramDB.png)

## Music_Player
For each song, the music is played and stopped using the JLayer library. The play function is shown in the picture below:

![image](https://github.com/OOP-Projects-2020-2021/Betting_Application/blob/master/res/json.png)

# Visuals

Here I posted some screenshots of the main scenes.

- `Sign In Page`

![image](https://github.com/OOP-Projects-2020-2021/Betting_Application/blob/master/res/signIn.png)

- `Bet Menu Page`

![image](https://github.com/OOP-Projects-2020-2021/Betting_Application/blob/master/res/betMenu.png)

- `Bet History Page`

![image](https://github.com/OOP-Projects-2020-2021/Betting_Application/blob/master/res/betHistory.png)

- `Admin Menu Page`  //which is a special kind of `User`

![image](https://github.com/OOP-Projects-2020-2021/Betting_Application/blob/master/res/adminMenu.png)

# Further

- A liked songs playlist that can be seen by the user.
- Another type of account: Artist. An artist will add new music and see only the reviews of them, their albums or their songs.