package com.cmcc.grpc;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

/**
 * @PackageName:com.cmcc.grpc
 * @ClassName:HelloWordClient
 * @Description:
 * @Author 陈磊
 * @Date 2020/1/3
 */
public class HelloWordClient {
    public static void main(String[] args) {
        ManagedChannel localhost = ManagedChannelBuilder.forAddress("localhost", 50051).usePlaintext().build();
        GreeterGrpc.GreeterBlockingStub stub = GreeterGrpc.newBlockingStub(localhost);
        HelloRequest hwb = HelloRequest.newBuilder().setName("Word").build();
        HelloReply helloReply = stub.sayHello(hwb);
        System.out.println(helloReply.getMessage());
    }
}
