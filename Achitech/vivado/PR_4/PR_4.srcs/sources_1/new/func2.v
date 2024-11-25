`timescale 1ns / 1ps

module func2(
    input [4:0] x,
    output f
    );
wire [3:0] w1_1, w2_1, w2_2, w3_1,w3_2, w3_3, w3_4, w3_5, w3_6,
w3_7,w3_8; 
// 1st level
dc#(2) dc0(.in({x[4], x[4]}), .enable(1'b1), .f(w1_1));
// 2nd level
dc#(2) dc1(.in({x[3], x[2]}), .enable(w1_1[0]), .f(w2_1));
dc#(2) dc2(.in({x[3], x[2]}), .enable(w1_1[3]), .f(w2_2)); 
// 3rd level
dc#(2) dc3(.in({x[1], x[0]}), .enable(w2_1[0]), .f(w3_1));
dc#(2) dc4(.in({x[1], x[0]}), .enable(w2_1[1]), .f(w3_2));
dc#(2) dc5(.in({x[1], x[0]}), .enable(w2_1[2]), .f(w3_3));
dc#(2) dc6(.in({x[1], x[0]}), .enable(w2_1[3]), .f(w3_4));

dc#(2) dc7(.in({x[1], x[0]}), .enable(w2_2[0]), .f(w3_5));
dc#(2) dc8(.in({x[1], x[0]}), .enable(w2_2[1]), .f(w3_6));
dc#(2) dc9(.in({x[1], x[0]}), .enable(w2_2[2]), .f(w3_7));
dc#(2) dc10(.in({x[1], x[0]}), .enable(w2_2[3]), .f(w3_8));

assign f = w3_1[1] | w3_2[1] | w3_2[2] | w3_2[3] | w3_3[0] | w3_4[0] | w3_4[1] | w3_4[2]
 | w3_5[0] | w3_5[3] | w3_6[0] | w3_6[1] | w3_7[3] | w3_8[1] | w3_8[2];
endmodule
