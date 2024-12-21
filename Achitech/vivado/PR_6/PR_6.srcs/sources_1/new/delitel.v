`timescale 1ns / 1ps
module delitel (
    input clk,
    output reg out
);
    wire [7:0] out_count;
    reg l=1;
    reg [6:0] count=0;
    reg mode=0;
    initial
        out = 0;
    count#(.mod(175))
    count2(.clk(clk), .dir(0), .out(out_count) );
    always@ (negedge clk or posedge clk)
    begin
        if(clk) begin
            if(mode==0)
            count=count+1;
            if (l==0 && count==88 && mode==0) begin
                mode=1;
                out = ~out;
                count=0;
            end
            if(out_count==0)
            l=1;
        else
            l=0;
        end
        else if(!clk) begin
            if (out_count == 0 && l==0 && mode==1) begin
                out = ~out;
                mode=0;
            end
        if(out_count==0)
            l=1;
        else
            l=0;
        end
    end
endmodule