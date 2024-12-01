`timescale 1ns / 1ps
module testbench();
    reg [4:0] args;
    reg clk;
    wire f_mux, f_dc, f_cd;
    reg [0:31] reference_reg, error_reg_mux,error_reg_dc, error_reg_cd;
    initial begin
        reference_reg = 32'h478E9C16;
        args = 0;
        clk = 0;
        error_reg_mux = 0;
        error_reg_dc = 0;
        error_reg_cd = 0;
    end
    always #10 clk = ~clk;
    always @(posedge clk) begin
        error_reg_mux[args] <= (f_mux ~^ reference_reg[args]);
        error_reg_dc[args] <= (f_dc ~^ reference_reg[args]);
        error_reg_cd[args] <= (f_cd ~^ reference_reg[args]);
        args <= args + 1;
        if (args == 32'h478E9C16)
            $finish;
    end
    func1 mx_f(
    .x(args),
    .f(f_mux)
    );
    func2 dc_f(
    .x(args),
    .f(f_dc)
    );
    func3 cd_f(
    .x(args),
    .f(f_cd)
    );
endmodule