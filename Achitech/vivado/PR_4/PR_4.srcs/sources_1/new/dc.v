`timescale 1ns / 1ps
module dc#(width = 2)(
    input[width - 1: 0] in,
    input enable,
    output [2**(width) - 1: 0] f
);
    assign f = !enable ? 0 : 1 << in;
endmodule