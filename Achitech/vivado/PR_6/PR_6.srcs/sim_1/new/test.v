`timescale 1ns / 1ps
module test();
reg clk = 0;
reg clk_ref = 0;
reg dir = 1;
wire [$clog2(175) - 1:0] out;
wire clk_div;
always #1 clk = ~clk;
always #175 clk_ref = ~clk_ref;

count #(1, 175) count1(.clk(clk), .dir(dir), .out(out));
delitel delitel(.clk(clk), .out(clk_div));
endmodule
