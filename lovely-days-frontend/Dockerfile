FROM node:14

WORKDIR /app

# add `/app/node_modules/.bin` to $PATH
ENV PATH /app/node_modules/.bin:$PATH
EXPOSE 4200

# install and cache app dependencies
COPY package.json /app/package.json
RUN npm install
RUN npm install -g @angular/cli@10.0.8

COPY . /app
#CMD ["ng", "serve", "--host", "0.0.0.0", "--disable-host-check"]
CMD ["ng", "build", "--prod"]
