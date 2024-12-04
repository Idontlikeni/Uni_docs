`timescale 1ns / 1ps
module delitel(
    input clk,
    output reg out
);
    wire [$clog2(87):0] out_count;
    initial
        out = 0;
    count#(1, 87) count2(.clk(clk), .dir(0), .out(out_count));
    always@(negedge clk)
    begin
        if(out_count == 0)
            out = ~out;
    end
endmodule
