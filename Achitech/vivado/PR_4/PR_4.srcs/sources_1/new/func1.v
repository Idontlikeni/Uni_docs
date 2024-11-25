`timescale 1ns / 1ps

module func1(
    input [4:0] x,
    output f
    );
wire w1_1,w1_2,w1_3,w1_4,w1_5,w1_6,w1_7,w1_8, w2_1,w2_2,w2_3,w2_4, w3_1,w3_2;
// 1st level
mux #(1) mux0(.a(x[1]), .in({x[0], 0}), .enable(1'b1), .f(w1_1));
mux #(1) mux1(.a(x[1]), .in({x[0], 1'b1}), .enable(1'b1), .f(w1_2));
mux #(1) mux2(.a(x[1]), .in({~x[0], 0}), .enable(1'b1), .f(w1_3));
mux #(1) mux3(.a(x[1]), .in({1'b1, ~x[0]}), .enable(1'b1), .f(w1_4));
mux #(1) mux4(.a(x[1]), .in({~x[0], x[0]}), .enable(1'b1), .f(w1_5));
mux #(1) mux5(.a(x[1]), .in({1'b1, 0}), .enable(1'b1), .f(w1_6));
mux #(1) mux6(.a(x[1]), .in({0, x[0]}), .enable(1'b1), .f(w1_7));
mux #(1) mux7(.a(x[1]), .in({x[0], !x[0]}), .enable(1'b1), .f(w1_8));
// 2nd level
mux #(1) mux8(.a(x[2]), .in({w1_1,w1_2}), .enable(1'b1), .f(w2_1));
mux #(1) mux9(.a(x[2]), .in({w1_3,w1_4}), .enable(1'b1), .f(w2_2));
mux #(1) mux10(.a(x[2]), .in({w1_5,w1_6}), .enable(1'b1), .f(w2_3));
mux #(1) mux11(.a(x[2]), .in({w1_7,w1_8}), .enable(1'b1), .f(w2_4));
//3rd level
mux #(1) mux12(.a(x[3]), .in({w2_1,w2_2}), .enable(1'b1), .f(w3_1));
mux #(1) mux13(.a(x[3]), .in({w2_3,w2_4}), .enable(1'b1), .f(w3_2));
// 4th level
mux #(1) mux14(.a(x[4]), .in({w3_1,w3_2}), .enable(1'b1), .f(f));
endmodule
