# Development

The application was developed with the help of [Docker](https://www.docker.com/) in [Visual Studio Code](https://code.visualstudio.com/) using the extension: [Dev Containers](https://marketplace.visualstudio.com/items?itemName=ms-vscode-remote.remote-containers)

# Build

- Clone repository using git, or simply download and unzip
- Install Docker
- Run the following commands where ```{PROJECT_DIRECTORY}``` is the root of the repository:
	- ```docker build -t java17-openjdk-maven {PROJECT_DIRECTORY}/.devcontainer```
	- ```docker build -t food-ordering-system-image {PROJECT_DIRECTORY}```
	- ```docker run -d -p 8080:8080 --name food-ordering-system-container food-ordering-system-image```
  
  For example, if already inside the project directory:
	- ```docker build -t java17-openjdk-maven ./.devcontainer```
	- ```docker build -t food-ordering-system-image .```
	- ```docker run -d -p 8080:8080 --name food-ordering-system-container food-ordering-system-image```
  
  ### Commands explanation
  - The first command builds the image containing the dev tools java and maven.
  - The second one builds an image that builds and runs the app based on the previous image.
  - The third one runs the image, exposing the 8080 port of it to local 8080 port
