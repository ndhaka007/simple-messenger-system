# Simple Messenger System (SMS)

Simple Messenger System (SMS) is a basic messaging application that allows users to send and receive messages. This project is currently under development and may have some issues.

## Requirements
1. Docker
2. Makefile

## Setup
1. Run `make build` to build the project.

## Testing Health Check
Test the health check by visiting the following endpoint:
- [Health Check](http://0.0.0.0:8080/health)

## Known Issues and Assumptions
- **Database Connection Issue**: There is an ongoing issue connecting to the database. Please check the configuration for potential errors.
- **Session Management**: Currently, the system does not create a session on login and logout. Instead, it tracks user activity using the `Active` field in the `users` table.
- **Protocol**: Using HTTP protocol for all the endpoints. Better will be to use web sockets to send and receive messages. 

## How to Use
1. Build the project using `make build`.
2. Test the health check to ensure the application is running.

## Contributing
Feel free to contribute to this project by opening issues or submitting pull requests. Your feedback and contributions are highly appreciated.

## License
This project is licensed under the [MIT License](LICENSE).

## Disclaimer
This project is a work in progress and may contain bugs. Use it at your own risk.