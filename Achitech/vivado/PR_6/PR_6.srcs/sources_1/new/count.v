`timescale 1ns / 1ps

module count#(step = 1, mod = 8)(
    input dir, clk,
    output reg [$clog2(mod)-1:0] out
);
    initial
        out = 0;
    always@(posedge clk)
    begin
        if(dir == 0)
            out = (out + step) % mod;
        else
            out = (out - step) % mod;
    end
endmodule
