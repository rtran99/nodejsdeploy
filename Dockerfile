FROM node:14-alpine

# Create a non-root user
RUN addgroup -g 1001 nodejs && \
    adduser -u 1001 -G nodejs -s /bin/sh -D nodejs

WORKDIR /usr/src/app

# Copy package.json and package-lock.json separately
COPY package*.json ./
RUN npm ci --only=production

# Copy index.js and source code
COPY index.js .
COPY src ./src

# Set non-root user
USER nodejs

# Expose port 3000 and start Node.js app
EXPOSE 3000
CMD [ "node", "index.js" ]
