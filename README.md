# WalletX Backend

A Spring Boot backend application that implements a digital wallet system.

## Features
- User creation
- Wallet creation per user
- Deposit and withdraw operations
- Insufficient funds protection (409 Conflict)
- Transaction history
- PostgreSQL persistence
- Flyway database migrations

## Tech Stack
- Java 17
- Spring Boot
- PostgreSQL
- Spring Data JPA
- Flyway
- Maven

## API Endpoints
- POST /api/users
- GET /api/users/{id}/wallet
- POST /api/users/{id}/wallet/deposit
- POST /api/users/{id}/wallet/withdraw
- GET /api/users/{id}/transactions

## Setup
1. Create PostgreSQL database `walletx`
2. Update `application.properties` with DB credentials
3. Run the application

