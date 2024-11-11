# TPDB Readme


## Introduction
This repo is the codebase for the Themepark Database platform. It consists of the backend, admin portal, website and app.

## Technnologies uses

### Overall

| Package 	  |   Version | Notes 	 |
|:-----------|----------:|---------|
| Node JS    | 22.9.0  	 |         |
| Docker     |   27.3.1 |         |



- Node.js 22.9.0

### Backend


| Package 	 | Version 	   | Notes |
|-----------|-------------|-------|
| NestJS    | 22.9.0  	  |       |
| Jest      | 27.3.1      |       |
 | TypeORM   | 0.2.38      |       |

- Nest.js 10.4.7

### Admin Portal

| Package 	 | Version 	   | Notes |
|-----------|-------------|-------|
| NestJS    | 22.9.0  	  |       |
| Jest      | 27.3.1      |       |
| TypeORM   | 0.2.38      |       |

### Website

| Package 	 | Version 	   | Notes |
|-----------|-------------|-------|
| NestJS    | 22.9.0  	  |       |
| Jest      | 27.3.1      |       |
| TypeORM   | 0.2.38      |       |

### App

| Package 	 | Version 	   | Notes |
|-----------|-------------|-------|
| NestJS    | 22.9.0  	  |       |
| Jest      | 27.3.1      |       |
| TypeORM   | 0.2.38      |       |


## Setup
### Docker
There are multiple docker compose files in de `devops/docker` folder That can be used to setup services that the platform relies on.
For each environment there is a docker compose file. The following environments are supported:
- Development
- Acceptance
- Production

The docker compose files are configured to use the docker.env file in the `devops/docker` folder. This file contains the environment variables that are used in the docker compose files. This file should not be commited to the repository. There is an `docker.env.example` file for reference The idea is that the `docker.env` file is created on the instance where the platform is deployed. 


To start the development environment run the following command:
```bash
docker compose -p tpdb-dev -f devops/docker/docker-compose.dev.yml up -d
```
### Backend

1. Run `npm install` to install the dependencies.
2. Run `npm run start:dev` to start the development server.


### Admin Portal

1. Run `npm install` to install the dependencies.
2. Run `npm run start` to start the development server.