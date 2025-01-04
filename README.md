Spring Tools Suite script I did up for the Oracle Internship Technical Challenge.


**Dockerising Instructions**

To dockerise, you need to have Docker Desktop installed on your PC and running. It can be downloaded from here: https://www.docker.com/products/docker-desktop/.

Then, open command prompt change directory to the root folder of the project. Run the command below to dockerise it:
docker run -p 8080:8080 oracle-challenge-app

**Running the App**

Assuming you are running it on Spring Tools (and hence the url will be localhost:8080), the API can be found in http://localhost:8080/Challenge1/minCoins.

It requires 2 parameters:
1. amount: the numerical amount you are trying to achieve
2. denominations: the list of denominations that the amount must constitute of

