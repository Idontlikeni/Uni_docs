`timescale 1ns / 1ps
module test();
    reg [5:0] a;
    reg [5:0] b;
    reg clk;
    initial begin
        a = 6'b101101;
        b = 6'b100011;
        clk = 0;
    end
    always #10 clk = ~clk;
    
    always@(posedge clk)
    begin
        a <= {a[4:0], a[5]};
        b <= {b[0], b[5:1]};
    end
endmodule