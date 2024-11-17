`timescale 1ns / 1ps
module testbench();
  reg [4:0] args;
  reg clk;
  wire sdnf, mdnf;
  reg [0:31] reference_reg, error_reg_sdnf, error_reg_mdnf;

  initial begin
    reference_reg = 32'h478E9C16;
    args = 0;
    clk = 0;
    error_reg_sdnf = 0;
    error_reg_mdnf = 0;
  end

  always #10 clk = ~clk;

  always @(posedge clk) begin
    error_reg_sdnf[args] <= (sdnf ~^ reference_reg[args]);
    error_reg_mdnf[args] <= (mdnf ~^ reference_reg[args]);
    args <= args + 1;
    if (args == 32'h478E9C16) 
      $finish;
  end

  main mod_f(
    .x(args),
    .f_SDNF(sdnf),
    .f_MDNF(mdnf)
  );

endmodule
