# Copy Laboratory Reservation System

The purpose of this project is to develop an application for laboratory reservations, specifically for the laboratories in the systems area of the Universidad Escuela Colombiana de Ingeniería Julio Garavito. This application will allow users to reserve each laboratory within the permitted schedule, as well as cancel reservations if necessary, and consult any type of information about each laboratory they need, all through a user-friendly and intuitive web interface. This repository is specifically for the Backend area; if you want to check the status of the front, follow this link: https://github.com/Waldron63/FrutiFront

## Tech Stack
- Java OpenJDK 17
- Spring Boot
- MongoDB Atlas
- Maven 3.9.x
- Docker
- JaCoCo for test coverage
- Sonar for code quality

## Development Team

- Alejandro Prieto
- Juan David
- María Paula Sánchez
- Santiago Gualdron

## Procedure of Laboratory 5:

primero empezamos a generar un nuevo archivo maven.yml con las instrucciones dadas en el laboratorio:

build: únicamente realizar hasta la fase compile de maven, es prerrequisito de test.
test: realizar la fase de verify y responder ¿se puede lograr que se ejecute sin necesidad de compilar el proyecto?, es dependiente (needs) de build para ser ejecutada, y a su vez es prerrequisito par hacer deploy.
deploy: por ahora deberá imprimir en consola "En construcción ...", necesita (needs) que se haya ejecutado test antes de iniciar.

![image](https://github.com/user-attachments/assets/dee9359f-7ddb-4d08-9f41-236339575f25)
![image](https://github.com/user-attachments/assets/882a1b18-c6bb-4e71-8465-bb57ada6ff5c)

se revisa que genere bien el gitflow actions:
![image](https://github.com/user-attachments/assets/22e880be-8d49-47c7-a044-72dea683cb25)

luego se agregan los siguientes test para revisar la funcionalidad de ReserveService:
![image](https://github.com/user-attachments/assets/03851a08-598a-4302-9ec5-40efe35e70f5)
![image](https://github.com/user-attachments/assets/0114f488-0943-4276-9891-b7af9630f3d5)
![image](https://github.com/user-attachments/assets/7e503b32-dcbd-42bd-b0bc-bb09a792bb08)
![image](https://github.com/user-attachments/assets/73031fc5-8dfa-41f8-8c5a-ce87cab291a4)
![image](https://github.com/user-attachments/assets/a34b31f9-2d61-4da2-9b13-abfb8a26dacf)

se vuelve a revisar el gitflow para confirmar que pasan las pruebas test
![image](https://github.com/user-attachments/assets/b010331c-eeef-4ae9-92e6-cff19ebe9701)
![image](https://github.com/user-attachments/assets/eec2a2d0-9dc5-4e06-832a-755896268766)

## Azure app:
se ingresa a la pagina oficial de Microsoft Azure for Students, en la zona de ofertas para estudiantes y agregamos le plan gratuito con 100 UDS
se inicia sesion con el correo de la escuela y se hacen los pasos de comprobacion hasta que aparezca el menu principal:
![image](https://github.com/user-attachments/assets/de1751a7-26cc-440b-b4dc-a3bc7e9061cd)
### Azure App Service 
![image](https://github.com/user-attachments/assets/01d0efb6-8eb3-4df7-b943-d146d7205b4c)
![image](https://github.com/user-attachments/assets/313d621e-7f00-4a93-86d2-279c96781639)
![image](https://github.com/user-attachments/assets/2f01baf4-bff1-4bd1-a724-fb2db2d97060)

![image](https://github.com/user-attachments/assets/e7c5802d-cfd8-4b74-aeb5-6a9b5f8f1cf5)
![image](https://github.com/user-attachments/assets/95aa4975-aa2c-47e3-9421-50005f3f6e3d)
![image](https://github.com/user-attachments/assets/260ad4c9-04a6-4bad-ba6b-91cef4f34e4d)
agregar:
![image](https://github.com/user-attachments/assets/25b7c46d-c76c-4408-aac4-2b14a56a5fb5)
![image](https://github.com/user-attachments/assets/73dab1aa-c1ad-44f2-b70e-5f1d58a09fed)

![image](https://github.com/user-attachments/assets/90f88992-ccbe-481d-b605-4da36a693d8f)
![image](https://github.com/user-attachments/assets/7bec574f-db17-4630-aca7-5350f23e156e)
