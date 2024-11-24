`timescale 1ns / 1ps
module cd#(width = 2)(
    input [2**(width) - 1: 0]in,
    output Q,
    output reg [width - 1: 0] f
    );
    integer n;
    always@(in)
    begin
        f = 0;
        for (n = 0; n <= 2**(width) - 1; n = n + 1)
        if (in[n])
        begin
            f = n;
        end
    end
    assign Q = in == 0;
endmodule