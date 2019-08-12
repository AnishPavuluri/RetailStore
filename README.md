# RetailStore
Sample RetailStore Application

## Getting Started

Modify the DB Details in db-details.properties
run the CREATE_TABLES.sql script to create the table

use the below maven command

>mvn clean install

by running the above command, it will run and execute the test cases

I copied my local DB Tables out put in the below path
RetailStore\src\test\db_results

SonarQube report is in the below path
RetailStore\src\test\sonar

Run the below commad to generate the sonar report. (sonar server is required)
>mvn sonar:sonar -Dsonar.host.url=http://localhost:9000

