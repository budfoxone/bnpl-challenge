## BNPL Stock price

Steps 

*build Java*

```shell
mvn clean package
```

#### build Docker container

```shell
docker build -t stock .
```

#### run Docker container
```shell
docker run -d -p 8080:8080 stock:latest
```

Access the site by going to
http://localhost:8080,  click the button to get the best value stock price



### Push Docker container to AWS ECR
download AWS CLI and follow ECR push commands

e.g.
####login
```shell
aws ecr get-login-password --region ap-southeast-2 | docker login --username AWS --password-stdin <AWS Account>.dkr.ecr.ap-southeast-2.amazonaws.com
```

####build container if not done above
```shell
docker build -t stock .
```

####tag your build
```shell
docker tag stock:latest <AWS Account>.dkr.ecr.ap-southeast-2.amazonaws.com/stock:latest
```

####push to ECR
```shell
docker push <AWS Account>.dkr.ecr.ap-southeast-2.amazonaws.com/stock:latest
```


### Upload CloudFormation template
Upload `fargate.yaml` to CloudFormation and fill in the parameters and stack name then create the stack

*Note: VPC and subnets will need to be provided*

