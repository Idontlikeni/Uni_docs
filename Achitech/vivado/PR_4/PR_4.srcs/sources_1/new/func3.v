`timescale 1ns / 1ps
module func3(
    input [4:0] x,
    output f
    );
    wire [31:0] f_dc0;
    wire Q;
    reg [1:0] in_cd;
    dc# (5) dc0(.in(x), .enable(1'b1), .f(f_dc0));
    always @(*)
    begin
        in_cd[1] = f_dc0[1] | f_dc0[5] | f_dc0[6] | f_dc0[7] | f_dc0[8] | f_dc0[12] | f_dc0[13] | f_dc0[14] | f_dc0[16] | f_dc0[19] | f_dc0[20] | f_dc0[21] | f_dc0[27] | f_dc0[29] | f_dc0[30];
    end
    cd#(1) cd1(.in(in_cd), .Q(Q), .f(f));
endmodule
