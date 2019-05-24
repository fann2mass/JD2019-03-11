<html>
<%@ include file="include/head.htm" %>
<body>
<div class="container">
    <%@ include file="include/menu.htm" %>
    <form class="form-horizontal" action="do?command=Login" method="post">
        <fieldset>

            <!-- Form Name -->
            <legend>Login</legend>

            <!-- Text input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="login">Login</label>
                <div class="col-md-4">
                    <input id="login" name="login" value="testUser" type="text" placeholder=""
                           class="form-control input-md" required="">
                    <span class="help-block">any symbols [a-z0-9]</span>
                </div>
            </div>

            <!-- Password input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="password">Password</label>
                <div class="col-md-4">
                    <input id="password" name="password" value="testPassword" type="password" placeholder=""
                           class="form-control input-md" required="">
                    <span class="help-block">min length 8 symols</span>
                </div>
            </div>

            <!-- Button -->
            <div class="form-group">
                <label class="col-md-4 control-label" for="signup"></label>
                <div class="col-md-4">
                    <button id="signup" name="signup" class="btn btn-success">Login</button>
                </div>
            </div>

        </fieldset>
    </form>
</div>
</body>
</html>

